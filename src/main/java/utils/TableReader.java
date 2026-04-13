package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TableReader {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public TableReader(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Extrae el valor legible de una celda:
     * - Si contiene un SVG, retorna su aria-label (ej: "Yes"/"No"), o data-testid como fallback.
     * - Si no, retorna el texto plano.
     */
    private String extractCellValue(WebElement cell) {
        List<WebElement> svgs = cell.findElements(By.tagName("svg"));
        if (!svgs.isEmpty()) {
            String ariaLabel = svgs.get(0).getAttribute("aria-label");
            if (ariaLabel != null && !ariaLabel.isBlank()) return ariaLabel;

            String dataTestId = svgs.get(0).getAttribute("data-testid");
            if (dataTestId != null && !dataTestId.isBlank()) return dataTestId;
        }
        return cell.getText();
    }

    /**
     * Lee el texto/value de un header (th) según posición.
     * @param tableHeadLocator Locator que apunta al thead
     * @param columnIndex Posición 0-based (0 = primera columna)
     * @return Texto del header
     */
    public String getHeaderValue(By tableHeadLocator, int columnIndex) {
        final String elementName = "tableHead";
        final String action = "read header value";
        try {
            WebElement thead = wait.until(ExpectedConditions.presenceOfElementLocated(tableHeadLocator));

            WebElement headerRow = thead.findElement(By.tagName("tr"));
            List<WebElement> headers = headerRow.findElements(By.tagName("th"));

            if (columnIndex < 0 || columnIndex >= headers.size()) {
                throw new IndexOutOfBoundsException(
                        String.format("Header index out of range. index=%d size=%d", columnIndex, headers.size())
                );
            }

            return extractCellValue(headers.get(columnIndex));

        } catch (IndexOutOfBoundsException e) {
            throw e;
        } catch (Exception e) {
            throw new AssertionError(
                    String.format("[ACTION FAILED] Element: %s | Locator: %s | Action: %s | Error: %s",
                            elementName, tableHeadLocator, action, e.getClass().getSimpleName()),
                    e
            );
        }
    }

    /**
     * Lee el texto/value de una celda del body, dado fila y columna.
     * Si la celda contiene un SVG, retorna su aria-label o data-testid.
     * @param tableBodyLocator Locator que apunta al tbody
     * @param rowIndex Posición fila 0-based
     * @param columnIndex Posición columna 0-based
     * @return Texto de la celda, o aria-label/data-testid si contiene SVG
     */
    public String getBodyCellValue(By tableBodyLocator, int rowIndex, int columnIndex) {
        final String elementName = "tableBody";
        final String action = "read body cell value";

        try {
            WebElement tbody = wait.until(ExpectedConditions.presenceOfElementLocated(tableBodyLocator));

            List<WebElement> rows = tbody.findElements(By.tagName("tr"));

            if (rowIndex < 0 || rowIndex >= rows.size()) {
                throw new IndexOutOfBoundsException(
                        String.format("Row index out of range. index=%d size=%d", rowIndex, rows.size())
                );
            }

            List<WebElement> cells = rows.get(rowIndex).findElements(By.tagName("td"));

            if (columnIndex < 0 || columnIndex >= cells.size()) {
                throw new IndexOutOfBoundsException(
                        String.format("Column index out of range. index=%d size=%d", columnIndex, cells.size())
                );
            }

            return extractCellValue(cells.get(columnIndex));

        } catch (IndexOutOfBoundsException e) {
            throw e;
        } catch (Exception e) {
            throw new AssertionError(
                    String.format("[ACTION FAILED] Element: %s | Locator: %s | Action: %s | Error: %s",
                            elementName, tableBodyLocator, action, e.getClass().getSimpleName()),
                    e
            );
        }
    }
}
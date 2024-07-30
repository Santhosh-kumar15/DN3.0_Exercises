public class FactoryMethodTest {
    public static void main(String[] args) {
        // Create a factory for Word Documents
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.create();

        // Create a factory for PDF Documents
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.create();

        // Create a factory for Excel Documents
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.create();
    }
}


package at.kleinknes.newBookClient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.kleinknes.newBookClient.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SaveBooksResponse_QNAME = new QName("http://BookServiceWebApp.kleinknes.at/", "saveBooksResponse");
    private final static QName _GetAllBooksResponse_QNAME = new QName("http://BookServiceWebApp.kleinknes.at/", "getAllBooksResponse");
    private final static QName _SearchBooksResponse_QNAME = new QName("http://BookServiceWebApp.kleinknes.at/", "searchBooksResponse");
    private final static QName _Book_QNAME = new QName("http://BookServiceWebApp.kleinknes.at/", "book");
    private final static QName _GetAllBooks_QNAME = new QName("http://BookServiceWebApp.kleinknes.at/", "getAllBooks");
    private final static QName _SaveBooks_QNAME = new QName("http://BookServiceWebApp.kleinknes.at/", "saveBooks");
    private final static QName _SearchBooks_QNAME = new QName("http://BookServiceWebApp.kleinknes.at/", "searchBooks");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.kleinknes.newBookClient.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link GetAllBooks }
     * 
     */
    public GetAllBooks createGetAllBooks() {
        return new GetAllBooks();
    }

    /**
     * Create an instance of {@link SaveBooks }
     * 
     */
    public SaveBooks createSaveBooks() {
        return new SaveBooks();
    }

    /**
     * Create an instance of {@link SearchBooks }
     * 
     */
    public SearchBooks createSearchBooks() {
        return new SearchBooks();
    }

    /**
     * Create an instance of {@link SearchBooksResponse }
     * 
     */
    public SearchBooksResponse createSearchBooksResponse() {
        return new SearchBooksResponse();
    }

    /**
     * Create an instance of {@link GetAllBooksResponse }
     * 
     */
    public GetAllBooksResponse createGetAllBooksResponse() {
        return new GetAllBooksResponse();
    }

    /**
     * Create an instance of {@link SaveBooksResponse }
     * 
     */
    public SaveBooksResponse createSaveBooksResponse() {
        return new SaveBooksResponse();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link Publisher }
     * 
     */
    public Publisher createPublisher() {
        return new Publisher();
    }

    /**
     * Create an instance of {@link Book.Authors }
     * 
     */
    public Book.Authors createBookAuthors() {
        return new Book.Authors();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BookServiceWebApp.kleinknes.at/", name = "saveBooksResponse")
    public JAXBElement<SaveBooksResponse> createSaveBooksResponse(SaveBooksResponse value) {
        return new JAXBElement<SaveBooksResponse>(_SaveBooksResponse_QNAME, SaveBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BookServiceWebApp.kleinknes.at/", name = "getAllBooksResponse")
    public JAXBElement<GetAllBooksResponse> createGetAllBooksResponse(GetAllBooksResponse value) {
        return new JAXBElement<GetAllBooksResponse>(_GetAllBooksResponse_QNAME, GetAllBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BookServiceWebApp.kleinknes.at/", name = "searchBooksResponse")
    public JAXBElement<SearchBooksResponse> createSearchBooksResponse(SearchBooksResponse value) {
        return new JAXBElement<SearchBooksResponse>(_SearchBooksResponse_QNAME, SearchBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Book }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BookServiceWebApp.kleinknes.at/", name = "book")
    public JAXBElement<Book> createBook(Book value) {
        return new JAXBElement<Book>(_Book_QNAME, Book.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BookServiceWebApp.kleinknes.at/", name = "getAllBooks")
    public JAXBElement<GetAllBooks> createGetAllBooks(GetAllBooks value) {
        return new JAXBElement<GetAllBooks>(_GetAllBooks_QNAME, GetAllBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BookServiceWebApp.kleinknes.at/", name = "saveBooks")
    public JAXBElement<SaveBooks> createSaveBooks(SaveBooks value) {
        return new JAXBElement<SaveBooks>(_SaveBooks_QNAME, SaveBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://BookServiceWebApp.kleinknes.at/", name = "searchBooks")
    public JAXBElement<SearchBooks> createSearchBooks(SearchBooks value) {
        return new JAXBElement<SearchBooks>(_SearchBooks_QNAME, SearchBooks.class, null, value);
    }

}

package bookstore

class BookController {
    static responseFormats = ['json', 'xml']

    def renderBook() {
        render(view: 'book', model: [title: 'hobbit', author: 'J.R.R Tolkein'])
    }

    def book() {
        [title: 'hobbit', author: 'J.R.R Tolkein']
    }
}

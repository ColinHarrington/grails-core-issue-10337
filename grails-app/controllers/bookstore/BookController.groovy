package bookstore

class BookController {
	static responseFormats = ['json', 'xml']
	
    def index() { 
    	render(view: 'book', model:[title: 'hobbit', author: 'J.R.R Tolkein'])
    }
}

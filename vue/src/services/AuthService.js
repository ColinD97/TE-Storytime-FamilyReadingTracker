import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },
/* Just throwing some random ideas out for now (KW) */
  showBooks(user){
    return axios.get('/books', user)
  },

  updateBook(book) {
    return axios.put(`/books/${book.id}`, book);
  },

}

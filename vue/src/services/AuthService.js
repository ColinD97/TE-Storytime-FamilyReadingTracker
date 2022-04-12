import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },
/* Working on connecting my ParentDashboard with what I want here -Reg


/* Just throwing some random ideas out for now (KW) */
  showBooks(user){
    return axios.get('/books', user)
  },

  updateBook(book) {
    return axios.put(`/books/${book.id}`, book);
  },

}

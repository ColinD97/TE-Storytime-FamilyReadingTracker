import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },
// Let user see bookshelf of 'to-read', 'currently reading', 'read'
  showBooks(user){
    return axios.get('/books', user)
  },

//Move book from 'to-read' to 'currently reading, etc'
  updateBook(userID,bookID) {
    return axios.put(`/bookshelf/${userID}/book/${bookID}`);
  },
  
}

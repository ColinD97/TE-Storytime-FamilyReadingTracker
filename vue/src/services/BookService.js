import axios from 'axios';

export default {
    
    showBooks(user){
    return axios.get('/books', user)
  },

//Move book from 'to-read' to 'currently reading, etc'
  updateBook(userID,bookID) {
    return axios.put(`/bookshelf/${userID}/book/${bookID}`);
  },
}
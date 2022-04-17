import axios from 'axios';

export default {
    
    getBooks(userId){
        return axios.get(`/bookshelf/${userId}`)
    },

    getAllBooks(){
        return axios.get('/bookshelf')
    },

    addBook(userId, book) {
        return axios.post(`/bookshelf/${userId}`, book)
    },

//For later
    updateBook(user, book) {
        return axios.put(`/bookshelf/${user}`, book);
    },

    deleteBooks(user) {
        return axios.delete(`/bookshelf/${user}`)

    },

// Reg Note:  Start of implementation of ReadingLog.vue code.  

   getUserBooksUserId(userId) {
        return axios.get(`/readinglog/${userId}`)
    },

    






}
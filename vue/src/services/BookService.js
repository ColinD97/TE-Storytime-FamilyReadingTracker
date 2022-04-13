import axios from 'axios';

export default {
    
    getBooks(user){
        return axios.get('/bookshelf', user)
    },

    addBooks(book) {
        return axios.post(`/bookshelf`, book)
    },

//For later
    updateBook(user, book) {
        return axios.put(`/bookshelf/${user}`, book);
    },


    deleteBooks(user) {
        return axios.delete(`/bookshelf/${user}`)

    }




}
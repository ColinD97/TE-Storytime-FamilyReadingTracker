import axios from 'axios';

export default {
    
    getBooks(userId){
        return axios.get(`/bookshelf/${userId}`)
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
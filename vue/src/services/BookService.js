import axios from 'axios';

export default {
    
    getBooks(userId){
        return axios.get(`/bookshelf/${userId}`)
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

    }

}
import axios from 'axios';

export default {
    
    getBooks(user){
        return axios.get('/bookshelf', user)
    },

    addBooks(book) {
        return axios.post(`/topics`, book)
    },

//For later
    updateBook(user, book) {
        return axios.put(`/topics/${user}`, book);
    },


    deleteBooks(user) {
        return axios.delete(`/topics/${user}`)

    }




}
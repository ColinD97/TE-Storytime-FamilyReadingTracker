import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },

  getParentId(user) {
    return axios.get(`/parent/${user}`); 
  },

  getFamilyByUserId(userId){
    console.log('get family by userId: '+userId)
    return axios.get(`/parent/dashboard/${userId}`)
  }
}

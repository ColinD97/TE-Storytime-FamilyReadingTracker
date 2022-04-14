<template>
  <div id="app">
    <div id="nav">
      <router-link class='container' v-bind:to="{ name: 'home' }">Home </router-link>
      <router-link class='container' v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> 
      <!-- <router-link class='container' v-bind:to="{ name: 'logout' }">Logout</router-link>  -->
      <router-link class='container' v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link> 
      <router-link class='container' v-bind:to="{ name: 'register' }">Register</router-link> 
      <router-link class='container' v-bind:to="{ name: 'parent', params: {id: this.currentUserId} }">Parent Dashboard</router-link> 
      <router-link class='container' v-bind:to="{ name: 'bookshelf', params: {id: this.currentUserId}}">Bookshelf</router-link> 
      <h4>*TEMPORARY* current user id: {{this.currentUserId}}</h4>
    </div>
    <router-view />
  </div>
</template>

<script>
// import { defineComponent } from '@vue/composition-api'

export default {
  name: 'app',
  data() {
    return {
      //currentUserId: this.$store.state.user.id
    }
  },
  computed: {
    currentUserId: function(){
      return this.$store.state.user.id
    }
  }

}
</script>



<style scoped>
.container {
    display: inline-flex;
    margin: 10px auto;
    padding: 20px;
  
}
#nav {
    list-style: none;
    font-family: "Arial Black", Gadget, sans-serif;
    font-size: 17px;
    letter-spacing: 2px;
    word-spacing: 2px;
    color: #000000;
    font-weight: normal;
    text-decoration: none;
    font-style: normal;
    font-variant: small-caps;
    text-transform: none;
}
</style>

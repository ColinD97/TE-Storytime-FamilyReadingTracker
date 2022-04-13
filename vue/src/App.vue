<template>
  <div id="app">
    <div id="nav">
      <router-link class='container' v-bind:to="{ name: 'home' }">Home </router-link>
      <router-link class='container' v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> 
      <router-link class='container' v-bind:to="{ name: 'logout' }">Logout</router-link> 
      <router-link class='container' v-bind:to="{ name: 'login' }">Login</router-link> 
      <router-link class='container' v-bind:to="{ name: 'register' }">Register</router-link> 
    </div>
    <router-view />
  </div>
</template>

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

<template>
    <div>
        <ul class="container" id="banner">
            <li class="item"><router-link v-bind:to="{ name: 'login' }">Login</router-link></li>
            <li class="item">FAQ</li>
            <li class="item"><router-link v-bind:to="{ name: 'register' }">Register</router-link></li>
        </ul>
        <h1 class="title">Temp Reading Tracker</h1>
        <h3 class= "subtext">Keep track of your kid's reading. Build habits for life.</h3> 
  </div>
</template>

<script>
// Don't need unless we are pulling in route info from router right??
// import AuthService from "../services/AuthService";

export default {
    name: 'AppHeader',
    // Longhand for props is an object with the prop name and type
    props: {
        pageHeader: String,
    },
    // Shorthand for props is just an array of the names
    // props: ['gardenName']
}
</script>

<style>
/*---------------------------------------*/
/* Top Banner */
/*---------------------------------------*/
.container {
    display: flex;
    justify-content: space-around;
    margin: 30px auto;
    padding: 30px;
  
}
#banner {
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
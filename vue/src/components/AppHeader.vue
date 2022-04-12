<template>
      <header>
      <h1>{{pageHeader}}</h1>
    </header>
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

</style>
<template>
      <header>
      <h1>{{pageHeader}}</h1>
    </header>
</template>

<script>
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
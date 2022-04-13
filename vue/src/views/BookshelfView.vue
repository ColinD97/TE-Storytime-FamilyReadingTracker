<template>
<div>
  <ul class="container" id="banner">
    <li class="item"><router-link v-bind:to="{ name: 'login' }">Login</router-link></li>
    <li class="item"><router-link v-bind:to="{ name: 'register' }">Register</router-link></li>
  </ul>
  <add-book />
</div>
</template>

<script>
import AddBook from '@/components/AddBook'

export default {
  components: {
    AddBook
  },  
}
</script>

<style>

</style>
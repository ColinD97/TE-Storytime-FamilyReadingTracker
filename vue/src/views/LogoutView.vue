<template>
  <div>
    <ul class="container" id="banner">
            <li class="item"><router-link v-bind:to="{ name: 'login' }">Login</router-link></li>
            <li class="item"><router-link v-bind:to="{ name: 'register' }">Register</router-link></li>
    </ul>
  </div>
</template>

<script>
// import AppHeader from "./components/Appheader.vue";

export default {
  // AppHeader,
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push("home");
  }
};
</script>

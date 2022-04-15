<template>
<div class="add-book">
      <h1 class="title">BookShelf</h1>
      <h3 class="subtext">Let's go on a reading adventure!</h3>
  <div class="book-container">
    <bookshelf v-for = "book in $store.state.books" v-bind:key="book.id" v-bind:book="book">
    </bookshelf>
    <add-book/>
  </div>
</div>
</template>

<script>
import Bookshelf from '../components/Bookshelf.vue'
import AddBook from '../components/AddBook.vue'
export default {
  components: { Bookshelf, AddBook },
    name: 'bookshelf-view',
    component: {Bookshelf}
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>
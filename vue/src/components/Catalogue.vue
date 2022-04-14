<template>
  <div class="add-book">
    <h1 class="title">Catalogue</h1>
    <h3 class="subtext">Welcome to your library</h3>
    <table class="bookshelf">
      <thead class="table-header">
        <tr class="header-row">
          <th>Title</th>
          <th>Author</th>
          <th>ISBN</th>
          <th>Difficulty</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="book in books" v-bind:key="book.book_id" class="table-row">
          <td>{{ book.title }}</td>
          <td>{{ book.author }}</td>
          <td>{{ book.isbn }}</td>
          <td>0000</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import BookService from "@/services/BookService.js";

export default {
  name: "Catalogue",
  data() {
    return {
      currentUserId: this.$store.state.user.id,
      books: [],
    };
  },
  components: {},
  created() {
    BookService.getAllBooks().then((response) => {
      this.books = response.data;
    });
  },
};
</script>

<style>
</style>
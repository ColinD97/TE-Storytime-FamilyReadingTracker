<template>
  <div class="add-book">
    <div class="title">
    <h1>Catalogue <span>Welcome to your library</span></h1>
    </div>
    <table class="catalogue">
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
          <td>{{ book.difficulty}}</td>
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
.catalogue {
  margin-left: auto;
  margin-right: auto;
  width: 80%;
  justify-content: center;
}
.catalogue td, .catalogue th {
  border: 1px solid #bbf2fc;
  padding: 8px;
}
.catalogue tr:nth-child(even){background-color: #f2f2f2;}

.catalogue tr:hover {background-color: #ddd;}

.catalogue th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #126c7c;
  color: white;
}
</style>
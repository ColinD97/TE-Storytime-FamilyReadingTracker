<template>
  <div>
    //Like book card from homework 13
    <div class="card" v-bind:class="{read: book.read}">
      <h2 class="title"> {{book.title}} </h2>
      <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
      <h3 class="book-author"> {{book.author}} </h3>
      <h3 class="book-isbn">{{ book.isbn}} </h3>
      <h3 class="book-difficulty">{{book.difficulty}} </h3>
    </div>
</div>
    <!-- <div class="add-book">
      <h1 class="title">BookShelf</h1>
      <h3 class="subtext">Let's go on a reading adventure!</h3>
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
      </table>-->
</template>

<script>
import BookService from "@/services/BookService.js";


export default {
  name: "Bookshelf",
  data() {
    return {
      currentUserId: this.$store.state.user.id,
      books: [],
    };
  },
  components: {
    
  },
  created() {
    BookService.getBooks(this.currentUserId).then((response) => {
      this.books = response.data;
    });
  },
};
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 3500px;
    margin: 20px;
}

.card.read {
    background-color: lightgray;
}

.card .book-title {
    font-size: 1.5rem;
}

.card .book-author {
    font-size: 1rem;
}
</style>
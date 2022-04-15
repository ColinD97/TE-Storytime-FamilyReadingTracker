<template>
<div>
  <book-card v-for="book in this.books" v-bind:key="book.id" v-bind:book="book"/>
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
import BookCard from './BookCard.vue';


export default {
  name: "Bookshelf",
  data() {
    return {
      currentUserId: this.$store.state.user.id,
      books: [],
    };
  },
  components: {
    BookCard
    
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
    text-align: center;
    border: 4px solid white;
    border-radius: 10px;
    width: 250px;
    height: 520px;
    margin: 20px;
}

.card.read {
    background-color: lightgray;
}

.card .book-title {
    font-size: 1rem;
}

.card .book-author {
    font-size: 1rem;
}
</style>
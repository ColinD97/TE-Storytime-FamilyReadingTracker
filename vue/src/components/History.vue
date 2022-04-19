<template>
  <div class="add-book">
    <div class="title">
    <h1>Reading History<span>Welcome to your library</span></h1>
    </div>
    <table class="history">
      <thead class="table-header">
        <tr class="header-row">
          <th class='left-end-top'>Title</th>
          <th class='middle'>Author</th>
          <th class='middle'>ISBN</th>
          <th class='right-end-top'>Difficulty</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="book in books" v-bind:key="book.book_id" class="table-row">
          <td class='left-end'>{{ book.title }}</td>
          <td class='middle'>{{ book.author }}</td>
          <td class='middle'>{{ book.isbn }}</td>
          <td class='right-end'>{{ book.difficulty}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import BookService from "@/services/BookService.js";

export default {
  name: "History",
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
.history {
  margin-left: auto;
  margin-right: auto;
  width: 70%;
  justify-content: center;
  font-weight: 100;
}
.history td, .history th {
  border: 1px solid #bbf2fc;
  padding: 10px;
  
}
.history tr:nth-child(even){background-color: #f2f2f2;}

.history th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #126c7c;
  color: white;
}
.history th:hover {background-color: #ddd;}

.left-end{
border-radius: 8px 3px 3px 8px;
}
.middle {
border-radius: 3px 3px 3px 3px;
}
.right-end{
border-radius: 3px 8px 8px 3px;
}
.right-end-top{
border-radius: 3px 8px 5px 3px;
}
.left-end-top {
border-radius: 8px 3px 3px 5px;
}
</style>
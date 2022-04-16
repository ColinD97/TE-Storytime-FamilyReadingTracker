<template>
<div class="book-shelf">
  <book-card v-for="book in this.books" v-bind:key="book.id" v-bind:book="book"/>  
  <!-- book after the colon has to match the name of the property inside the nested component. to the right of = is the thing you're passing in. inside the book card, 19  -->
</div>
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
.book-shelf {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}

</style>
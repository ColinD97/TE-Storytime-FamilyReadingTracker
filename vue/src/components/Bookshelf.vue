<template>
<div class="book-shelf">
  <v-layout row class="mb-3">
    <v-btn class="btn" small flat color="grey" @click="sortBy('title')">By Title</v-btn>
    <v-btn class="btn" small flat color="grey" @click="sortBy('author')">By Author</v-btn>
    <v-btn class="btn" small flat color="grey" @click="sortBy('genre')">By Genre</v-btn>
    <v-btn class="btn" small flat color="grey" @click="sortBy('difficulty')">By Difficulty</v-btn>
  </v-layout>
  <book-card v-for="book in this.books" v-bind:key="book.id" v-bind:book="book"/>  
</div>
</template>

<script>
import BookService from "@/services/BookService.js";
import BookCard from './BookCard.vue';


export default {
  name: "Bookshelf",
  data() {
    return {
      currentFamilyId: this.$store.state.user.family_id,
      books: [],
    };
  },
  components: {
    BookCard
    
  },

    methods: {
    sortBy(property){
      this.books.sort((a,b) => a[property] < b[property] ? -1 : 1)
    }
  },

  created() {
    BookService.getBooks(this.currentFamilyId).then((response) => {
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
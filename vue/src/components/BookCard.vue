<template>
  <div>
    <!-- Like book card from homework 13 -->
    <!-- flexbox -->
    <div class="card">
      <h2 class="title"> {{book.title}} </h2>
      <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
      <!-- <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/9780064430555-M.jpg'" /> -->
      
      <h3 class="book-author">Author: {{book.author}} </h3>
      <h3 class="book-isbn">ISBN: {{ book.isbn}} </h3>
      <h3 class="book-difficulty">Difficulty: {{book.difficulty}} </h3>
    </div>
  </div>
</template>

<script>
export default {
    props: ['book'],

}
</script>

<style>
.card {
    text-align: center;
    padding: 2px;
    border: 4px solid white;
    border-radius: 10px;
    width: 250px;
    height: 520px;
    margin: 20px;
}

.card.read {
    background-color: rgb(208, 245, 245);
}

.card .book-title {
    color:157788;
    font-size: 1rem;
}

.card .book-author {
    font-size: 1rem;
}

</style>
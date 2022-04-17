<template>
  <div class='card-container'>
    <!-- Like book card from homework 13 -->
    <!-- flexbox -->
    <div class="card">
      <h2 class="title"> {{book.title}} </h2>
      <img class='cover' v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
      <p class="book-author">Author: {{book.author}} </p>
      <p class="book-isbn">ISBN: {{ book.isbn}} </p>
      <p class="book-difficulty">Difficulty: {{book.difficulty}} </p>
    </div>
  </div>
</template>

<script>
export default {
    props: ['book'],  
    // using this book to refer to use similar idea to use on parent dashboard when adding book to vbind: family-users and pass that in that data, and on the add book side make prop and i can use it!
    // parent dashboard view an parent dashboard component: DONT MOVE COMPONENT INTO VIEW colin understands child vs parent with one dashboard view
}
</script>

<style>

.card {
    font-family: "Arial Black", Gadget, sans-serif;
    padding: 2px;
    border: 4px solid white;
    border-radius: 10px;
    width: 270px;
    height: 520px;
    margin: 20px;
    transition: 0.3s;
    text-align: center;
    align-content: center;
}
.card .card.read {
    background-color: rgb(208, 245, 245);
}
.card .book-title {
    text-align: center;
    color:157788;
    font-size: 14px;
}
.card .book-author {
    text-align: center;
    font-size: 14px;
}
.card .cover{
  border-radius: 5px 5px 0 0;
  
}

</style>
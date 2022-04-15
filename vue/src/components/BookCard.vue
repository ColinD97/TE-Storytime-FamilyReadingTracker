<template>
    <div>
    <!-- Like book card from homework 13 -->
    <div class="card" v-bind:class="{read: book.read}">
      <h2 class="title"> {{book.title}} </h2>
      <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
      <!-- <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/9780064430555-M.jpg'" /> -->
      
      <h3 class="book-author"> {{book.author}} </h3>
      <h3 class="book-isbn">{{ book.isbn}} </h3>
      <h3 class="book-difficulty">{{book.difficulty}} </h3>
    </div>
</div>
</template>

<script>
export default {
    props: ['book'],

}
</script>

<style>

</style>
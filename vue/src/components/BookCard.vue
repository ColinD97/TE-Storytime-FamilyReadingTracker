<template>
  <div class='card'>
      <h4 class="title"> {{book.title}} </h4>
      <div class='cover'>
        <img id="cover" v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
      </div>
      <h4 class="book-author">Author: {{book.author}} </h4>
      <h4 class="book-isbn">ISBN: {{ book.isbn}} </h4>
      <h4 class="book-difficulty">Difficulty: {{book.difficulty}} </h4>
    </div>
</template>

<script>
export default {
    props: ['book'],  
}
</script>

<style>

.card {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 60px 300px 30px 30px 20px;
  gap: 3px;
  font-family: "Arial Black", Gadget, sans-serif;
  border: 4px solid white;
  border-radius: 10px;
  width: 270px;
  height: 520px;
  padding: 5px;
  margin: 15px;
  text-align: center;
  align-content: center;
}
.card .book-title {
  grid-row: 1;
  color: #222222;
}
.card .cover{
  background: rgba(59, 150, 142, 0.8);
  border-radius: 10px 10px 10px 10px;
  grid-row: 2; 
}
#cover{
  border-radius: 5px 5px 5px 5px;
  vertical-align: center;
}
.card .book-author {
  grid-row: 3;
  text-align: center;
}
.card .book-isbn {
  grid-row: 4;
}
.card .book-difficulty {
  grid-row: 5;
}

h4 {
  margin: 0px;
  color: 222222;
}

</style>
<template>
  <div class='card'>
      <h4 class="title"> {{book.title}} </h4>
      <div class='cover'>
        <img id="cover" v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
      </div>
      <h4 class="book-author">{{book.author}} </h4>
      <h5 class="book-isbn">ISBN: {{ book.isbn}} </h5>
      <h5 class="book-difficulty">Difficulty: {{book.difficulty}} </h5>
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
  grid-template-rows: 70px 300px 30px 30px 20px;
  gap: 3px;
  font-family: "Arial Black", Gadget, sans-serif;
  border: 4px solid white;
  border-radius: 10px;
  width: 310px;
  height: 530px;
  padding: 5px;
  margin: 15px;
  text-align: center;
  align-content: center;
}
.card .book-title {
  grid-row: 1;
  color: #222222;
  padding-bottom:10px;
}
.card .cover{
  background: rgba(77, 170, 162, 0.3);
  border-radius: 10px 10px 10px 10px;
  grid-row: 2; 
}
#cover{
  border-radius: 5px 5px 5px 5px;
  position: relative;
  top: 50%;
  transform: translateY(-50%);
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
  color: #222222;
}
h5 {
  font-size:14px;
}

</style>
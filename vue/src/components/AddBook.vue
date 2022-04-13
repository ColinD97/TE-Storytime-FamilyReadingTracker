<template>
    
<div class='buttons'>
    <button class="btn btn-lg btn-primary btn-block" type="submit" v-on:click="addBook()">
        Add New Book
      </button>
    <button class="btn btn-lg btn-primary btn-block" type="submit">
        Move Book
      </button>
</div>
</template>

<script>

import BookService from '@/services/BookService.js';

export default {
  name: 'add-book',
  data() {
    return {
      book: {
        title: "",
        author: "",
        isbn: "",
      }
    };
  },
  methods: {
    addBook() {
      BookService
        .create(this.book)
        .then(response => {
          if (response.status === 201) {
            this.$router.push({name: 'bookshelf'});
          }
        })

    }
  }
};

</script>

<style>
.buttons{
    text-align: center;
}
.bookshelf{
    width:100%
}
.table-header{
    color:darkblue;
}
.header-row{
    height:30px;
}
table, th, td {
  border: 1px solid black;
}

</style>
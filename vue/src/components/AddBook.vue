<template>
    
<div>
  <div class="form-body">
            <!-- Title and Author -->
            <div class="horizontal-group">
                <div class="form-group left">
                    <label for="title" class="label-title">Book Title</label>
                    <input
                        type="text"
                        id="title"
                        class="form-input"
                        placeholder="Book Title"
                        v-model="book.title"
                        required
                        autofocus
                    />
                    </div>
                <div class="form-group right">
                    <label for="author" class="label-title">Author</label>
                    <input
                        type="text"
                        id="author"
                        class="form-input"
                        placeholder="Author"
                        v-model="book.author"
                        autofocus
                    />
                    </div>
            </div>
            <!-- ISBN -->
            <div class="horizontal-group">
                <div class="form-group">
                    <div class="form-group left">
                        <label for="email" class="label-title">ISBN</label>
                        <input
                            type="text"
                            id="isbn"
                            class="form-input"
                            placeholder="ISBN"
                            v-model="book.isbn"
                            autofocus
                        />
                    </div>
                </div>
            </div>
            </div>
    <button class="btn" type="submit" v-on:click="addBook">
        Submit Form
      </button>
    <button class="btn" type="submit">
        Move Book
      </button>
</div>
</template>

<script>

import BookService from '@/services/BookService.js';

export default {
  name: 'add-book',
  props: ['userId'],
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
      console.log('add book'+ this.book)
      BookService
        .addBook(this.userId, this.book)
        .then(response => {
          if (response.status === 201) {
            this.$router.push({path: '/'});
          }
        })

    }
  }
};

</script>

<style>
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
.btn-body {
    display: inline-block;
    padding: 10px 10px;
    background-color: #1ca3dc;
    font-size: 17px;
    border: none;
    border-radius: 5px;
    color: #bcf5e7;
    cursor: pointer;
}
.btn-body:hover {
    background-color: #169c7b;
    color: white;
}

</style>
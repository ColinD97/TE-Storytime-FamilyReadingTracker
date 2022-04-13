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
                    <label for="authro" class="label-title">Author</label>
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
                    <div class="form-group right">
                        <label for="username" class="label-title">Username</label>
                        <input
                            type="text"
                            id="username"
                            class="form-input"
                            placeholder="Username"
                            v-model="user.username"
                            required
                            autofocus
                        />
                    </div>
                </div>
            </div>
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
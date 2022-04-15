<template>
    
<div>
  <form class="form-add-book" @submit.prevent="register">
    <h1 class="form-header">Add Book Details:</h1>
    <div class="form-body">
            <!-- Title and Author -->
            <div class="horizontal-group">
                <div class="form-group left">
                    <label for="title" class="label-title">Book Title</label>
                    <input
                        type="text"
                        id="title"
                        class="form-input"
                        placeholder=""
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
                        placeholder=""
                        v-model="book.author"
                        autofocus
                    />
                    </div>
            </div>
            <!-- ISBN -->
            <div class="horizontal-group">
                    <div class="form-group left">
                        <label for="email" class="label-title">ISBN</label>
                        <input
                            type="text"
                            id="isbn"
                            class="form-input"
                            placeholder=""
                            v-model="book.isbn"
                            autofocus
                        />
                    </div>
                    <div class="form-group right">
                    <label for="difficulty" class="label-title">Difficulty</label>
                    <input
                        type="text"
                        id="difficulty"
                        class="form-input"
                        placeholder="1 through 5"
                        v-model="book.difficulty"
                        autofocus
                    />
                    </div>
                </div>
            </div>
              <div class="form-footer">
                <button class="btn" type="submit" v-on:click="addBook" >
                Add Book
                </button>
                <button class="btn" type="submit">
                Move Book
                </button>
                <label for="assign">Assign book to:</label>
                <select name="assign" id="assign">
                <option value="user1">Colin</option>
                <option value="user2">Kai</option>
                <option value="user3">Reg</option>
                <option value="user4">Nolan</option>
                </select>
              </div>           
  </form>
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
        difficulty: "",
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
    background-color: #157788;
    color: white;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  padding: 12px 16px;
  z-index: 1;
}

.dropdown:hover .dropdown-content {
  display: block;
}

</style>
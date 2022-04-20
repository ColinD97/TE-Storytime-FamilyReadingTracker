<template>
    
<div>

  <form class="form-add-book">
    <h1 class="form-header">Add A Book To Family Collection</h1>
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
            <!-- ISBN and Difficulty-->
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
                    <select
                        class="drop-down"
                        name="difficulty"
                        id="difficulty"
                        v-model="book.difficulty"
                        autofocus
                    >
                      <option disabled hidden value="">Pick Difficulty</option>
                      <option selected value="1">1</option>
                      <option value="2">2</option>
                      <option value="3">3</option>
                      <option value="4">4</option>
                      <option value="5">5</option>
                    </select>
                    </div>
                </div>
            </div>
              <div class="form-footer">
                <button class="btn" type="submit" v-on:click="addBook">
                Add Book
                </button>
                  <!-- <div class="custom-select" style="width:350px;" id='dropdown'>
                    <label for="custom-select">Assign book to:</label>
                    <select 
                    class="drop-down"
                    v-model= "assignToUser" 
                    style="width:150px;" 
                    >
                      <option disabled hidden value="">Children:</option>
                      <option v-for="user in familyUsers" v-bind:key="user.index" :value="user.id">{{user.first_name}}</option>
                    </select>
                  </div>   -->
                </div> 
  </form>
</div>
</template>

<script>

import BookService from '@/services/BookService.js';

export default {
  name: 'add-book',
  props: ['familyUsers'],  
  // 1. this.book.userID not from here, get from property entering into the form
  data() {
    return {
      book: {
        title: "",
        author: "",
        isbn: "",
        difficulty: "",
        genre: "",
      },
      assignToUser: "",
      isbnErrors: false,
      isbnErrorMsg: 'ISBN needs to be a 13 digit number.',
      
    };
  },
  methods: {
    addBook() {
      if (this.book.isbn !== (/([0-9]){13}/g)) {
        this.isbnErrors = true;
        this.isbnErrorMsg = 'ISBN needs to be a 13 digit number.';
      } else {
      console.log('add book'+ this.book)
      BookService
      // Assign to family ID
        .addBook(this.assignToUser, this.book)
        .then(response => {
          if (response.status === 201) {              
              this.book = {
                title: '',
                author: '',
                isbn: '',
                difficulty: '',
                genre: '',       
              },
            alert('AddBook successful!  Hurray for our side!'),
            this.$router.push({path: '/'});
          }
        })
      }
    }
  }
}


</script>

<style>
/*---------------------------------------*/
/* Buttons */
/*---------------------------------------*/
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


</style>
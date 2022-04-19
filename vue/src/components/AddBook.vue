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
      assignToUser: ""
      
    };
  },
  methods: {
    addBook() {
      console.log('add book'+ this.book)
      BookService
        .addBook(this.assignToUser, this.book)
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
/*---------------------------------------*/
/* Drop-Down Menu */
/*---------------------------------------*/
/* .form-header{
  font-size: 30px;
} */
.form-footer .custom-select {
  width: 200px;
}
.form-footer .select-selected:after {
  position: absolute;
  content: "";
  top: 14px;
  right: 10px;
  width: 0;
  height: 0;
  border: 6px solid transparent;
  border-color: #fff transparent transparent transparent;
}

/* Point the arrow upwards when the select box is open (active): */
.form-footer .select-selected.select-arrow-active:after {
  border-color: transparent transparent #fff transparent;
  top: 7px;
}

/* style the items (options), including the selected item: */
.form-footer .select-items div,.select-selected {
  color: #ffffff;
  padding: 8px 16px;
  border: 1px solid transparent;
  border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
  cursor: pointer;
}

/* Style items (options): */
.form-footer .select-items {
  position: absolute;
  background-color: DodgerBlue;
  top: 100%;
  left: 0;
  right: 0;
  z-index: 99;
}

/* Hide the items when the select box is closed: */
.form-footer .select-hide {
  display: none;
}

.form-footer .select-items div:hover, .same-as-selected {
  background-color: rgba(0, 0, 0, 0.1);
}

</style>
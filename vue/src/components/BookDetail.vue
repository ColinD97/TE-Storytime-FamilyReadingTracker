<template>
<div></div>
  <!-- <form v-on:submit.prevent="submitForm" class="bookForm">
    <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
    <div class="form-group">
      <label for="title">Title:</label>
      <input id="title" type="text" class="form-control" v-model="book.title" autocomplete="off" />
    </div>
    <div class="form-group">
      <label for="tag">Author:</label>
      <select id="tag" class="form-control" v-model="book.author">
        <option value="Feature Request">Feature Request</option>
      </select>
      <label for="status">Status:</label>
      <select id="tag" class="form-control" v-model="book.status">
        <option value="Planned">Planned</option>
        <option value="In Progress">In Progress</option>
        <option value="Completed">Completed</option>
      </select>
    </div>
    <div class="form-group">
      <label for="description">ISBN:</label>
      <textarea id="description" class="form-control" v-model="book.isbn"></textarea>
    </div>
    <button class="btn btn-submit" type="submit">Submit</button>
    <button class="btn btn-cancel" v-on:click.prevent="cancelForm" type="cancel">Cancel</button>
  </form> -->
</template>

<script>
// import bookShelf from "../services/BookShelf";

// export default {
//   name: "BookShelf",
//   props: {
//     userID: {
//       type: Number,
//       default: 0
//     }
//   },
  // data() {
  //   return {
  //     book: {
  //       bookId: "",
  //       title: "",
  //       author: "",
  //       status: "",
  //       isbn: "",
  //     },
  //     errorMsg: ""
  //   };
  // },
  // methods: {
  //   submitForm() {
  //     const newBook = {
  //       bookId:this.book.bookID,
  //       title: this.book.title,
  //       author: this.book.author,
  //       status: this.book.status,
  //       isbn: this.book.isbn,
  //     };

  //     if (this.bookID === 0) {
        // add
      //   bookShelf
      //     .addbook(newbook)
      //     .then(response => {
      //       if (response.status === 201) {
      //         this.$router.push(`/board/${newbook.boardId}`);
      //       }
      //     })
      //     .catch(error => {
      //       this.handleErrorResponse(error, "adding");
      //     });
      // } else {
        // update
  //       newbook.id = this.bookID;
  //       newbook.avatar = this.book.avatar;
  //       newbook.date = this.book.date;
  //       bookShelf
  //         .updatebook(newbook)
  //         .then(response => {
  //           if (response.status === 200) {
  //             this.$router.push(`/board/${newbook.boardId}`);
  //           }
  //         })
  //         .catch(error => {
  //           this.handleErrorResponse(error, "updating");
  //         });
  //     }
  //   },
  //   cancelForm() {
  //     this.$router.push(`/board/${this.$route.params.boardID}`);
  //   },
  //   handleErrorResponse(error, verb) {
  //     if (error.response) {
  //       this.errorMsg =
  //         "Error " + verb + " book. Response received was '" +
  //         error.response.statusText +
  //         "'.";
  //     } else if (error.request) {
  //       this.errorMsg =
  //         "Error " + verb + " book. Server could not be reached.";
  //     } else {
  //       this.errorMsg =
  //         "Error " + verb + " book. Request could not be created.";
  //     }
  //   }
  // },
  // Want data to load when things first display? Put them in created!
//   created() {
//     if (this.bookID != 0) {
//       bookShelf
//         .getbook(this.bookID)
//         .then(response => {
//           this.book = response.data;
//         })
//         .catch(error => {
//           // Bad status - need to make users aware an error has occurred
//           if (error.response && error.response.status === 404) {
//             // An alert is a decent choice to show errors to your user
//             // other alternatives might be to render a box on the page w/ red background, etc
//             alert(
//               "book not available. This book may have been deleted or you have entered an invalid book ID."
//             );
//             // Send the user somewhere they can continue working...
//             this.$router.push("/");
//           }
//         });
//     }
//   }
// };
</script>
<template>
  <div class="child-register">
    <h1 class="title">Bookshelf</h1>
    <h3 class= "subtext">Keep track of your kid's reading. Build habits for life.</h3>
    
    <!-- <form class="form-register" @submit.prevent="register"> -->
    <h1 class="form-header">Add new book:</h1>
    <!-- <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }} -->


  <div class="form-body">
            <!-- Firstname and Lastname -->
            <div class="horizontal-group">
                <div class="form-group left">
                    <label for="title" class="label-title">Book Title *</label>
                    <input
                        type="text"
                        id="title"
                        class="form-input"
                        placeholder="Book Title"
                        v-model="user.title"
                        required
                        autofocus
                    />
                </div>
                <div class="form-group right">
                    <label for="author" class="label-title">Author Name *</label>
                    <input
                        type="text"
                        id="author"
                        class="form-input"
                        placeholder="Author Name"
                        v-model="user.author"
                        required
                        autofocus
                    />
                    </div>
            </div>
    </div>
    </div>
</template>

<script>
// import AppHeader from "./components/Appheader.vue";

export default {
  components: {
    // BookDetail,
    // AppHeader
  }
};
</script>
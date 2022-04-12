<template>
  <div class="child-register">
      <ul class="container" id="banner">
      <li class="item"><router-link v-bind:to="{ name: 'login' }">Login</router-link></li>
      <li class="item">FAQ</li>
    </ul>
    <h1 class="title">Bookshelf</h1>
    <h3 class= "subtext">Keep track of your kid's reading. Build habits for life.</h3>
    
    <!-- <form class="form-register" @submit.prevent="register"> -->
    <h1 class="form-header">Add new book:</h1>
    <!-- <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }} -->
    <!-- </div> -->

  <div class="form-body">
            <!-- Firstname and Lastname -->
            <div class="horizontal-group">
                <div class="form-group left">
                    <label for="firstname" class="label-title">First Name *</label>
                    <input
                        type="text"
                        id="firstname"
                        class="form-input"
                        placeholder="First Name"
                        v-model="user.firstname"
                        required
                        autofocus
                    />
                    </div>
                <div class="form-group right">
                    <label for="lastname" class="label-title">Last Name *</label>
                    <input
                        type="text"
                        id="lastname"
                        class="form-input"
                        placeholder="Last Name"
                        v-model="user.lastname"
                        required
                        autofocus
                    />
                    </div>
            </div>
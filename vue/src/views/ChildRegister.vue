<template class="home">
  <div class="child-register">
      <ul id="banner">
      <li><router-link v-bind:to="{ name: 'login' }">Login</router-link></li>
      <li>FAQ</li>
    </ul>
    <h1 id="title">Create Child Account</h1>
    <h3 id= "subtext">Keep track of your kid's reading. Build habits for life.</h3>
    
    
    <form class="form-register" @submit.prevent="register">
      <h1 class="form-header">Child Info:</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>

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
            <!-- Email -->
            <div class="horizontal-group">
                <div class="form-group">
                    <div class="form-group left">
                        <label for="email" class="label-title">Email Address *</label>
                        <input
                            type="text"
                            id="email"
                            class="form-input"
                            placeholder="Valid Email Address"
                            v-model="user.email"
                            required
                            autofocus
                        />
                    </div>
                    <div class="form-group right">
                        <label for="username" class="label-title">Username *</label>
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
                <div class="horizontal-group">
                    <div class="form-group left">
                        <label for="password" class="label-title">Password *</label>
                        <input
                            type="password"
                            id="password"
                            class="form-input"
                            placeholder="Password"
                            v-model="user.password"
                            required
                        />
                         <label for="confirm-password" class="label-title">Confirm Password *</label>
                        <input
                            type="password"
                            id="confirmPassword"
                            class="form-input"
                            placeholder="Confirm Password"
                            v-model="user.confirmPassword"
                            required
                        />
                    </div>
                </div>
        
            <div class="form-footer">
                <button class="btn" type="submit">
                Create Child Account
                </button>
            </div>
        </div>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        firstname: '',
        lastname: '',
        email: '',
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>


</style>
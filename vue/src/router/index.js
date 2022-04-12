import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/HomeView.vue'
import Login from '../views/LoginView.vue'
import Logout from '../views/LogoutView.vue'
import Register from '../views/RegisterView.vue'
import store from '../store/index'
import ParentDash from '../views/ParentDashboardView.vue'
import ParentChildDash from '../views/ParentChildDashView.vue'
import FamilyRegister from '../views/ChildRegisterView.vue'
import BookShelf from '../views/BookshelfView.vue'
import AddBook from '../views/AddBookView.vue'



Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register/family",
      name: "register-family",
      component: FamilyRegister,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/parent",
      name: "parent",
      component: ParentDash,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/parent/child-dash/:userID",
      name: "parent-child-view",
      component: ParentChildDash,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/bookshelf/:userID',
      name: 'bookshelf',
      component: BookShelf,
    },
    {
      path: '/bookshelf/:userID/book/:bookID',
      name: 'add-book',
      component: AddBook
    },
    
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;

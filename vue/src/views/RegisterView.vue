<template>
  <div>
    <AppHeader />
    <RegistrationForm />
  </div>
</template>

<script>
import AppHeader from "./components/Appheader.vue";
import RegistrationForm from '@/components/RegistrationForm';

export default {
  components: {
    RegistrationForm,
    AppHeader
  }
};
</script>

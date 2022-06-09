export default function isAuthenticated() {
  if (window) {
    const token = localStorage.getItem('token');
    if (token) {
      return true;
    }
    return false;
  }
}
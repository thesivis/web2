export default function headerAuthorization() {
  if (window) {
      const token = localStorage.getItem('token');
      if (token) {
          return { Authorization: `Bearer ${ token}` };
      } 
  }
  return {};
}
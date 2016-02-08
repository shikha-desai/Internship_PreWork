from django.contrib.auth.models import AnonymousUser, User
from django.test import TestCase, Client
from rest_framework.test import APITestCase, APIClient
from rest_framework import status


# Create your tests here.

class UserRestAPITest(APITestCase):
    def setUp(self):
        self.client = APIClient()
        self.user = User.objects.create_superuser('admin', 'shikha.desai@ishisystems.com', 'password@admin')
        # self.client.force_authenticate(user=self.user)
        self.client.login(username='admin', password='password@admin')

    def tearDown(self):
        self.client.logout()

    def test_get(self):
        response = self.client.get('/users/')
        self.assertEqual(response.status_code, 200)

    def test_post(self):
        response = self.client.post('/users/', data={'username': 'jkl', 'email': 'jkl@nirma.com'})
        self.assertEqual(response.status_code, status.HTTP_201_CREATED)
        self.assertEqual(User.objects.count(), 2)
        self.assertEqual(User.objects.get(username='jkl').email, 'jkl@nirma.com')
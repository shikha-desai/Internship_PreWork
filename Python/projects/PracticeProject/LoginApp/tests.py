from django.contrib.auth.models import AnonymousUser, User, Group
from django.test import TestCase, Client, LiveServerTestCase
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from rest_framework.test import APIClient, APITestCase
from rest_framework import status
from django.contrib.auth.hashers import make_password
from django.core.urlresolvers import reverse
import logging


# Create your tests here.

class UserRestAPITest(APITestCase):
    def setUp(self):
        self.client = APIClient()
        User.objects.create_superuser('admin', 'shikha.desai@ishisystems.com', 'password@admin')
        # self.client.force_authenticate(user=self.user)
        self.client.login(username='admin', password='password@admin')
        self.url = 'http://localhost:8000/LoginApp/users/'

    def tearDown(self):
        self.client.logout()

    def test_get(self):
        response = self.client.get(self.url, format='json')
        self.assertEqual(response.status_code, 200)

    def test_post(self):
        passwd = make_password('jkl')
        response = self.client.post(self.url, data={'username': 'jkl', 'email': 'jkl@nirma.com', 'password':passwd}, format='json')
        self.assertEqual(response.status_code, status.HTTP_201_CREATED)
        self.assertEqual(User.objects.count(), 2)
        self.assertEqual(User.objects.get(username='jkl').email, 'jkl@nirma.com')


class GroupRestAPITest(APITestCase):
    def setUp(self):
        self.client = APIClient()
        User.objects.create_superuser('admin', 'shikha.desai@ishisystems.com', 'password@admin')
        # self.client.force_authenticate(user=self.user)
        self.client.login(username='admin', password='password@admin')
        self.url = 'http://localhost:8000/LoginApp/groups/'

    def tearDown(self):
        self.client.logout()

    def test_get(self):
        response = self.client.get(self.url, format='json')
        self.assertEqual(response.status_code, 200)

    def test_post(self):
        response = self.client.post(self.url, data={'name': 'g1',}, format='json')
        self.assertEqual(response.status_code, status.HTTP_201_CREATED)
        self.assertEqual(Group.objects.count(), 1)
        self.assertEqual(Group.objects.get(name='g1').name, 'g1')


class SignUpTest(LiveServerTestCase):
    def setUp(self):
        self.driver = webdriver.Firefox()
        self.driver.maximize_window()

    def tearDown(self):
        self.driver.quit()

    def test_for_rendering(self):
        logger = logging.getLogger(__name__)
        self.driver.get(
            '%s%s' % (self.live_server_url, "/LoginApp/signup/")
        )

        username = self.driver.find_element_by_id('username')
        username.send_keys('something')
        email = self.driver.find_element_by_id('email')
        email.send_keys('something@gmail.com')
        password = self.driver.find_element_by_id('password')
        password.send_keys('something')

        logger.info(self.driver.current_url)
        # self.driver.find_element_by_xpath('//input[@value="Sign Up"]').click()
        self.driver.find_element_by_id("signupForm").submit()
        self.assertEqual('http://localhost:8082/LoginApp/', self.driver.current_url)

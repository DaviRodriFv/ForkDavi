from locust import HttpUser, task, between
import random

marcas = ["Honda", "Yamaha", "Suzuki", "Kawasaki", "BMW"]
modelos = ["CB 500", "MT-07", "GSX-R", "Ninja 400", "G 310 R"]

class MotoUser(HttpUser):
    wait_time = between(1, 3)
    moto_id = None

    headers = {
        "Content-Type": "application/json",
        "X-API-KEY": "my1j8UFkBnzGF8QXh08wMRW9tSaSS0TIm2sC-cYmuQ4"
    }

    @task(1)
    def criar_moto(self):
        payload = {
            "marca": random.choice(marcas),
            "modelo": random.choice(modelos),
            "ano": random.randint(2000, 2024),
            "preco": round(random.uniform(15000.0, 80000.0), 2),
            "cilindrada": random.choice([150, 300, 400, 500, 650, 750, 1000])
        }

        response = self.client.post(
            "/api/moto",
            json=payload,
            headers=self.headers
        )

        if response.status_code == 200:
            data = response.json()
            self.moto_id = data.get("id")

    @task(2)
    def buscar_moto(self):
        if self.moto_id:
            self.client.get(
                f"/api/moto/{self.moto_id}",
                headers=self.headers
            )